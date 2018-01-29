
; app.extra is not imported in namespace
(ns app.main
  (:require [shadow.loader :as loader]))

(defn on-error []
  (println "on error"))

; instead, app.extra is loaded by generated code
(defn on-load []
  (println "on load")
  ((resolve 'app.extra/async-code!)))

; the file is loaded with "extra",
; the name is defined in shadow,cljs.edn
(defn main! []
  (println "main!")
  (loader/with-module "extra" on-load))

(defn reload! []
  (println "reload!"))

(set! (.-onload js/window) main!)
