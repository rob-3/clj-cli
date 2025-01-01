(ns dev.rob-3.clj-cli)

(defn choice [options]
  (loop []
    (let [numbered-options (map vector (range) options)]
      (doseq [[i o] numbered-options]
        (println (str i ":") o))
      (print "> ")
      (let [input (-> (read-line) parse-long)]
        (if (contains? (->> numbered-options (mapv first) set) input)
          (-> (nth numbered-options input) second)
          (recur))))))

(comment
  (with-in-str "1"
    (choice ["option a" "option b" "option c"]))
  (with-in-str "\nasdfasdf\n3\n0"
    (choice ["option a" "option b" "option c"])))
