
(ns app.main
  (:require [shadow.loader :as loader]
            [app.extra :as extra]))

(defn on-load []
  (println "on load")
  (extra/async-code!))

(defn on-error []
  (println "on error"))

(defn main! []
  (println "main!")
  (loader/with-module "extra" on-load))

(defn reload! []
  (println "reload!"))

(set! (.-onload js/window) main!)
