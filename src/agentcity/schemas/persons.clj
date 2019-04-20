(ns agentcity.schemas.persons
  (:require [schema.core :as sc]
            [agentcity.utilities.string_util :as str]))

(defn valid-first-name? [firstname]
  (str/length-in-range? 1 50 firstname))

(defn valid-last-name? [lastname]
  (str/length-in-range? 1 50 lastname))

(defn valid-phonenumber? [phonenumber]
  (str/length-in-range? 11 15 phonenumber))

(defn valid-contact-address? [address]
  (str/length-in-range? 6 100 address))


;Schema for Person that will be mapped to table
(sc/defschema PersonSchema
  {:FirstName (sc/constrained sc/Str valid-first-name?)
   :LastName (sc/constrained sc/Str valid-last-name?)
   :PhoneNumber (sc/constrained sc/Str valid-phonenumber?)
   :Email (sc/constrained sc/Str str/email?)
   :ContactAddress (sc/constrained sc/Str valid-contact-address?)})

