(ns agentcity.utilities.string_util
  (:require [clojure.string :as str]))

(def non-blank? (complement str/blank?))

;maximul length validation
(defn max-length? [length text]
  (<= (count text) length))
;
(defn non-blank-with-max-length? [length text]
  (and (non-blank? text) (max-length? length text)))

;minimu length validation
(defn min-length? [length text]
  (>= (count text) length))

;check if string is conflicting with max and min length critiria
(defn length-in-range? [min-length max-length text]
  (and (min-length? min-length text) (max-length? max-length text)))

;regrex for email validation
(def email-regex
  #"(?i)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")

;check if text is an email
(defn email? [email]
  (boolean (and (string? email) (re-matches email-regex email))))