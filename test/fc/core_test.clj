(ns fc.core-test
  (:use [midje.sweet])
  (:require [fc.core :as fc]
            [conf-er :as cfr]))



(fact "API Version must be correctly read from config "
      (let [conf (cfr/config :config)
            ver (conf :version)]
        (some? ver) => true
        (fc/version) => ver))
