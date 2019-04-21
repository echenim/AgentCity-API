(ns agentcity.schemas.user
  (:require [schema.core :as sc]
            [agentcity.utilities.string_util :as str]))

(defn valid-username? [name]
  (str/non-blank-with-max-length? 50 name))

(defn valid-password? [password]
  (str/length-in-range? 5 15 password))

(defn valid-email? [email]
  (str/email?  email))

;User schema defination
(sc/defschema UserSchema
  {:UserName (sc/constrained sc/Str valid-username?)
   :Password (sc/constrained sc/Str valid-password?)
   :Email (sc/constrained sc/Str valid-email?)})