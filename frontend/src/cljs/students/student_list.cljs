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
  (let [students @state]
    (if (empty? students)
      [:p "В группе нет студентов."]
      [:table.table.table-striped
       [:thead
        [:tr
         [:th "Фамилия"]
         [:th "Имя"]
         [:th "Отчество"]
         [:th "Дата рождения"]]]
       [:tbody
        (for [student students]
          (let [student-id (:id student)]
            ^{:key student-id}
            [:tr
             [:td [:a {:href (format "#/students/%s" student-id)}
                   (:last_name student)]]
             [:td (:first_name student)]
             [:td (:patronymic_name student)]
             [:td (:date_birth student)]]))]])))
