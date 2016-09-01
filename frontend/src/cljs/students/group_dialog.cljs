(ns students.group-dialog
  (:refer-clojure :exclude [update])
  (:require
   [students.utils :refer [format]]
   [students.student-list :as student-list]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defonce state (r/atom nil))

(defn update-handelr [group]
  (reset! state group))

(defn update [group-id]
  (let [url (format "/api/groups/%s/" group-id)]
    (GET url {:response-format :json
              :keywords? true
              :handler update-handelr})))

(defn close []
  (reset! state nil))

(defn component []
  (when-let [group @state]
    [:div
     [:h4 (format "№%s %s" (:number group) (:title group))]
     [:p (:subtitle group)]
     [:p (format "%s форма обучения" (:edu_form group))]
     [:p (format "%s курс" (:course group))]
     [:p (format "%s уровень образования" (:edu_level group))]
     [student-list/component (:id group)]]))
