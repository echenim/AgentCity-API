(ns agentcity.userendpoints
  (:require [agentcity.models.user :refer [User]]
            [buddy.hashers :as hasher]
            [clojure.set :refer [rename-keys]]
            [toucan.db :as db]
            [ring.util.http-response :refer [created]]
            [compojure.api.sweet :refer [POST]]))

(defn id->created [id]
  (created (str "/Users/" id)
           {:id id}))
;Canonicalize the request by hashing the password,
; the rename the key password with password_hash (to match the column name in the database)
(defn canonicalize-user-req [user-req]
  (-> (update user-req :password hashers/derive)
      (rename-keys {:password :password_hash})))

;The create-user-handler function takes a
; create-user-req a coerced version of the JSON
(defn create-user-handler [create-user-req]
  (->> (canonicalize-user-req create-user-req)
       (db/insert! User)
       :id
       id->created))


(def user-routes
  [(POST "api/users" []
     :body [create-user-req UserSchema] (create-user-handler create-user-req))])