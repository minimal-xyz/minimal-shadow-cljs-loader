
(ns copy-html.core
  (:require ["fs" :as fs]
            [clojure.string :as string]
            [cljs.reader :refer [read-string]]))

(defn -main []
  (let [file (fs/readFileSync "assets/index.html" "utf8")
        assets (read-string (fs/readFileSync "dist/assets.edn" "utf8"))
        written-file (string/replace file "main.js" (-> assets (get 0) :output-name))]
    (fs/writeFileSync "dist/index.html" written-file)
    (println "written to dist/index.html")))

(-main)
