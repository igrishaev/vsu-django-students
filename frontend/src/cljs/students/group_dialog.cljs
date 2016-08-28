(ns students.group-dialog
  (:refer-clojure :exclude [update])
  (:require
   [students.utils :refer [format]]
   [students.student-list :as student-list]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(defonce state (r/atom nil))

(defn update-handelr [group]
  (reset! state group)
  (student-list/update (:id group)))

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
     (:title group)
     [student-list/component]]))

;; (defn group-dialog []
;;   (when-let [group @atom-group]
;;     [:div.modal-dialog.modal-lg
;;      [:div.modal-content
;;       [:div.modal-header
;;        [:button {:type "button" :class "close"}
;;         [:span {:aria-hidden "true" :on-click close-group} "×"]]
;;        [:h4 (:title group)]]
;;       [:div.modal-body
;;        [:p (:subtitle group)]
;;        [:p (:edu_level group)]
;;        [:p (:edu_form group)]]]]))
;;        ;; (let [students (r/atom nil)
;;        ;;       url (format "/api/groups/%s/students/" (:id group))]
;;        ;;   (GET url {:format :json
;;        ;;             :keywords? true
;;        ;;             :handler #()
