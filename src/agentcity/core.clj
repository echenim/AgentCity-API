(ns agentcity.core
  (:require [toucan.db :as db]
            [toucan.models :as models]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.api.sweet :refer [routes]]
            [spec-tools.swagger.core :as swagger]
            [agentcity.endpoints.user :refer [user-routes]])
  (:gen-class))

(def db-spec
   {:dbtype "postgres"
    :dbname "restful-crud"
    :user "postgres"
    :password "test"})

  (def swagger-config
    {:ui "/swagger"
     :spec "/swagger.json"
     :options {:ui {:validatorUrl nil}
               :data {:info {:version "1.0.0", :title "Restful CRUD API"}}}})

  (def app (api {:swagger swagger-config} (apply routes user-routes)))


  (defn -main
    [& args]
    (db/set-default-db-connection! db-spec)
    (models/set-root-namespace! agentcity.models)
    (run-jetty app {:port 30000}))