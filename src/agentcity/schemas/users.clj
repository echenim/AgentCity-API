(ns agentcity.schemas.users
  (:require [schema.core :as s]
            [agentcity.utilities.string_util :as str]))
(defn valid-username? [name]
  (str/non-blank-with-max-length? 50 name))

(defn valid-password? [password]
  (str/length-in-range? 5 15 password))

(defn valid-email? [email]
  (str/email?  email))

;User schema defination
(s/defschema UserSchema
  {:UserName (s/constrained s/Str valid-username?)
   :Password (s/constrained s/Str valid-password?)
   :Email (s/constrained s/Str valid-email?)})