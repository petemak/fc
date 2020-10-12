(ns fc.core-test
  (:use [midje.sweet])
  (:require [fc.core :as fc]
            [cprop.core :as cp]))



(fact "Version must be correct"
      (let [conf (cp/load-config)
            ver (conf :version)]
        (fc/version) => ver))
