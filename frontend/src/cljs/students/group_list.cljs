(ns students.group-list
  (:refer-clojure :exclude [update])
  (:require
   [students.utils :refer [format]]
   [students.group-dialog :as group-dialog]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defonce state (r/atom nil))

(defn update []
  (GET "/api/groups/" {:handler #(reset! state %)
                       :response-format :json
                       :keywords? true}))

(defn close []
  (reset! state nil))

(defn component []
  [:div
   (when-let [groups @state]
     [:table.table.table-striped
      [:thead
       [:tr
        [:th "Номер"]
        [:th "Группа"]
        [:th "Курс"]
        [:th "Ур. образования"]]]
      [:tbody
       (for [group groups]
         (let [group-id (:id group)]
           ^{:key group-id}
           [:tr
            [:td (:number group)]
            [:td [:a {:href (format "#/groups/%s" group-id)}
                  (:title group)]]
            [:td (:course group)]
            [:td (:edu_level group)]]))]])])
