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
    [:div
     [:h4 (format "%s %s %s"
                  (:last_name student)
                  (:first_name student)
                  (:patronymic_name student))]
     [:p (format "Дата рождения: %s" (:date_birth student))]
     [:p (format "%s курс" (:course student))]
     (let [group (:group student)]
       [:p
        (format "Группа №%s " (:number group))
        [:a {:href (format "#/groups/%s" (:id group))}
         (:title group)]])]))
