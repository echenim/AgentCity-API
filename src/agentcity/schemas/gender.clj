(ns agentcity.schemas.gender
  (:require [schema.core :as sc]
            [agentcity.utilities.string_util :as str]))

(defn valid-name? [name]
  (str/non-blank-with-max-length? 10 name))

(sc/defschema Gender
  {:Id (sc/Int)
   :Name (sc/constrained sc/Str valid-name?)})