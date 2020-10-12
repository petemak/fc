(ns fc.core
  (:require [cprop.core :as conf]))

;;===============================================
;; Application state
(def state (atom nil))


;;===============================================
;; Application state
(defn load-state
  "Initiate stae atom"
  []
  (try
    (reset! state (conf/load-config))
    (catch Exception e (str "could not load configuration: " (.getMessage e)))))

;;===============================================
;; Reads version from state
(defn version
  "Applcation version"
  []
  (if (nil? @state)
    (load-state))
  (:version @state))


;;===============================================
;; Reads version from state
(defn -main
  "Applcation entry point"
  []
  (load-state)
  (println "::dc.core => FC server started ..."))
