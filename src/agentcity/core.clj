(ns agentcity.core
  (:require [toucan.db :as db]
            [toucan.models :as models]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.api.sweet :refer [routes]]
            [agentcity.userendpoints :refer [user-routes]])
  (:gen-class))

(def app (apply routes user-routes))

(def db-spec
  {:dbtype "postgres"
   :dbname "restful-crud"
   :user "postgres"
   :password "postgres"})

(defn -main
  [& args]
  (db/set-default-db-connection! db-spec)
  (models/set-root-namespace! 'agentcity.models))
  (run-jetty app {:port 3000})

