(ns students.student-list
  (:refer-clojure :exclude [update])
  (:require
   [students.utils :refer [format]]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defonce state (r/atom nil))

(defn update [group-id]
  (let [url (format "/api/groups/%s/students/" group-id)]
    (GET url {:response-format :json
              :keywords? true
              :handler #(reset! state %)})))

(defn component []
  (when-let [students @state]
    [:div
     (for [student students]
       ^{:key (:id student)}
       [:a {:href (format "#/students/%s" (:id student))} (:first_name student)])]))
