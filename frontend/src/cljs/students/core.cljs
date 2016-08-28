(ns students.core
  (:require
   [secretary.core :as secretary :refer-macros [defroute]]
   [reagent.core :as r]

   [students.utils :refer [format]]
   [students.group-list :as group-list]
   [students.group-dialog :as group-dialog]
   [students.student-dialog :as student-dialog]
   ))

(enable-console-print!)

(secretary/set-config! :prefix "#")

(defroute #"/groups/(\d+)" [id]
  (group-dialog/update id))

(defroute #"/students/(\d+)" [id]
  (student-dialog/update id))

(set! (.-onhashchange js/window)
      #(-> js/window
           .-location
           .-hash
           secretary/dispatch!))

(defn layout-component []
  [:div
   [group-list/component]
   [group-dialog/component]
   [student-dialog/component]])

(defn ^:export main []
  (r/render [layout-component] (js/document.getElementById "app"))
  (group-list/update))

(main)

;; (defn ^:export run []
;;   (set-on-hash-change)
;;   (r/render [layout-component] (js/document.getElementById "app"))
;;   (update-groups))


;; (ns students.core
;;   (:require
;;    [goog.string.format]
;;    [reagent.core :as r]
;;    [ajax.core :refer [GET]]))

;; (enable-console-print!)

;; (def groups (r/atom []))
;; (def atom-group (r/atom nil))
;; (def atom-student (r/atom nil))
;; (def atorm-students (r/atom nil))

;; ;; (defn update-students [group-id]
;; ;;   (let [url ()]
;; ;;     (GET )))

;; (defn update-groups []
;;   (GET "/api/groups/" {:handler #(reset! groups %)
;;                        :response-format :json
;;                        :keywords? true}))

;; (defn open-student [id]
;;   {:pre [(number? id)]}
;;   (let [url (format "/api/students/%s/" id)]
;;     (GET url {:response-format :json
;;               :keywords? true
;;               :handler #(reset! atom-student %)})))

;; (defn close-student []
;;   (reset! atom-student nil))

;; (defn open-group [id]
;;   ;; {:pre [(number? id)]}
;;   (let [url (format "/api/groups/%s/" id)]
;;     (GET url {:response-format :json
;;               :keywords? true
;;               :handler #(reset! atom-group %)})))

;; (defn close-group []
;;   (reset! atom-group nil))

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

;;        ;;             )
;;        ;; (students-table (:id group))]]]))

;; ;; (defn students-table [group-id]
;; ;;   {:pre [(number? group-id)]}
;; ;;   (let [url (format "/api/groups/%s/students/" group-id)]
;; ;;     (GET url {:format :json
;; ;;               :keywords? true
;; ;;               :handler (fn [students]
;; ;;                          [:h3 "Студенты"]
;; ;;                          [:table.table.table-striped
;; ;;                           [:thead
;; ;;                            [:tr
;; ;;                             [:th "Фамилия"]
;; ;;                             [:th "Имя"]
;; ;;                             [:th "Отчество"]]]
;; ;;                           [:tbody
;; ;;                            (for [student students]
;; ;;                              [:tr
;; ;;                               [:td (:last_name student)]
;; ;;                               [:td (:first_name student)]
;; ;;                               [:td (:patronymic_name student)]])]])})))

;; (defn student-dialog []
;;   (when-let [student @atom-student]
;;     [:div "stud"]))

;; (defn groups-list-component []
;;   [:table.table.table-striped
;;    [:thead
;;     [:tr
;;      [:th "Номер"]
;;      [:th "Группа"]
;;      [:th "Курс"]
;;      [:th "Ур. образования"]]]
;;    [:tbody
;;     (for [group @groups]
;;       (let [group-id (:id group)]
;;         ^{:key group-id}
;;         [:tr
;;          [:td (:number group)]
;;          [:td [:a {:href "#" :on-click #(open-group group-id)} (:title group)]]
;;          [:td (:course group)]
;;          [:td (:edu_level group)]]))]])

;; (def atom-hash (r/atom nil))

;; (defn dispatch-component []
;;   (when-let [url-hash @atom-hash]
;;     (when-let [match (re-matches #"^#/groups/(\d+)/" url-hash)]
;;       (open-group (second match)))))

;; (defn foo-component []
;;   (when-let [url-hash @atom-hash]
;;     [:div url-hash]))

;; (defn layout-component []
;;   [:div
;;    (dispatch-component)
;;    ;; (foo-component)
;;    (groups-list-component)
;;    (group-dialog)
;;    (student-dialog)])

;; (defn set-on-hash-change []
;;   (set! (.-onhashchange js/window)
;;         #(reset! atom-hash (-> js/window .-location .-hash))))

;; (defn ^:export run []
;;   (set-on-hash-change)
;;   (r/render [layout-component] (js/document.getElementById "app"))
;;   (update-groups))

;; ;; (def routes {#"^#/$" widget-group-list
;; ;;              #"^#/groups/(\d+)$" widget-group-item
;; ;;              #"^#/students/(\d+)$" widget-student-item})

;; (run)

;; ;; <div class="modal-dialog modal-lg" role="document">
;; ;;     <div class="modal-content">
;; ;;         <div class="modal-header">
;; ;;             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
;; ;;                 <span aria-hidden="true">×</span>
;; ;;             </button>
;; ;;             <h4 class="modal-title" id="myLargeModalLabel">Large modal</h4>
;; ;;         </div>
;; ;;         <div class="modal-body"> ... </div>
;; ;;     </div>
;; ;; </div>
