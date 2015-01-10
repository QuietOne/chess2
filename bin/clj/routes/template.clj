(ns routes.template
  (:use hiccup.core)
  (:use hiccup.page)
  (:use hiccup.form)
  )

(defn layout [title & content]
  "Include only title of page and body content"
  (html
    (doctype :xhtml-strict)
    ;[:script {:src "http://fb.me/react-0.12.1.js"}]
    (include-css "/style.css")
    (xhtml-tag "en"
               [:head
                [:meta {:http-equiv "Content-type"
                        :content "text/html; charset=utf-8"}]
                 [:title title]]
               [:body content]
      )
    )
  )

(defn layout-css [title css & content]
  "Include title of page, css and body content"
  (html
    (doctype :xhtml-strict)
    ;[:script {:src "http://fb.me/react-0.12.1.js"}]
    (include-css css)
    (xhtml-tag "en"
               [:head
                [:meta {:http-equiv "Content-type"
                        :content "text/html; charset=utf-8"}]
                 [:title title]]
               [:body content]
      )
    )
  )