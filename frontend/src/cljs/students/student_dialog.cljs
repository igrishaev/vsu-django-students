(ns students.student-dialog
  (:refer-clojure :exclude [update])
  (:require
   [students.utils :refer [format]]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defonce state (r/atom nil))

(defn update [id]
  (let [url (format "/api/students/%s/" id)]
    (GET url {:response-format :json
              :keywords? true
              :handler #(reset! state %)})))

(defn close []
  (reset! state nil))

(defn component []
  (when-let [student @state]
    [:div (:first_name student)]))
