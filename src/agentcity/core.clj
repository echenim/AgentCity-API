(ns agentcity.core
  (:require [toucan.db :as db]
            [toucan.models :as models])
  (:gen-class))

(def db-spec
  {:dbtype "postgres"
   :dbname "restful-crud"
   :user "postgres"
   :password "postgres"})

(defn -main
  [& args]
  (db/set-default-db-connection! db-spec)
  (models/set-root-namespace! 'resultful-crud.models))
