
(ns app.main)

(defn on-load []
  (println "on load"))

(defn on-error []
  (println "on error"))

(defn main! []
  (println "main!"))

(defn reload! []
  (println "reload!"))

(set! (.-onload js/window) main!)
