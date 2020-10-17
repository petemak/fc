(ns fc.core
  (:require [conf-er :as conf]))

;;===============================================
;; Application state
(def config (atom nil))


;;===============================================
;; Application state
(defn load-config
  "Initiate stae atom"
  []
  (try
    (reset! config (conf/config :config))
    (catch Exception e (str "could not load configuration: " (.getMessage e)))))

;;===============================================
;; Reads version from state
(defn version
  "Applcation version"
  []
  (if (nil? @config)
    (load-config))
  (:version @config))


;;===============================================
;; Reads version from state
(defn -main
  "Applcation entry point"
  []
  (load-config)
  (println "::dc.core => FC server started ..."))
