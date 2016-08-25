(ns students.core
  (:require
   [goog.string.format]
   [reagent.core :as r]
   [ajax.core :refer [GET]]))

(enable-console-print!)

(def format #'goog.string.format)

(def groups (r/atom []))
(def atom-group (r/atom nil))
(def atom-student (r/atom nil))

(defn update-groups []
  (GET "/api/groups/" {:handler #(reset! groups %)
                       :response-format :json
                       :keywords? true}))

(defn open-student [id]
  {:pre [(number? id)]}
  (let [url (format "/api/students/%s/" id)]
    (GET url {:response-format :json
              :keywords? true
              :handler #(reset! atom-student %)})))

(defn open-group [id]
  {:pre [(number? id)]}
  (let [url (format "/api/groups/%s/" id)]
    (GET url {:response-format :json
              :keywords? true
              :handler #(reset! atom-group %)})))

(defn group-dialog []
  (when-let [group @atom-group]
    [:div.modal-dialog.modal-lg
     [:div.modal-content
      [:div.modal-header
       [:button {:type "button" :class "close"}
        [:span {:aria-hidden "true"
                :on-click #(reset! atom-group nil)} "×"]]]
      [:div.modal-body (:title group)]]]))

(defn student-dialog []
  (when-let [student @atom-student]
    [:div "stud"]))

(defn groups-list-component []
  [:div
   (for [group @groups]
     (let [group-id (:id group)]

       ^{:key group-id} [:div {:on-click #(open-group group-id)} (:title group)]

       ))])

(defn layout-component []
  [:div
   (groups-list-component)
   (group-dialog)
   (student-dialog)])

(defn ^:export run []
  (r/render [layout-component] (js/document.getElementById "app"))
  (update-groups))

(run)

;; <div class="modal-dialog modal-lg" role="document">
;;     <div class="modal-content">
;;         <div class="modal-header">
;;             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
;;                 <span aria-hidden="true">×</span>
;;             </button>
;;             <h4 class="modal-title" id="myLargeModalLabel">Large modal</h4>
;;         </div>
;;         <div class="modal-body"> ... </div>
;;     </div>
;; </div>
