(ns chess2.chessboard
  (require clojure.set))

(def init-pos 
  {:a ["wr" "wp" "." "." "." "." "bp" "br"]
   :b ["wn" "wp" "." "." "." "." "bp" "bn"]
   :c ["wb" "wp" "." "." "." "." "bp" "bb"]
   :d ["wq" "wp" "." "." "." "." "bp" "bq"]
   :e ["wk" "wp" "." "." "." "." "bp" "bk"]
   :f ["wb" "wp" "." "." "." "." "bp" "bb"]
   :g ["wn" "wp" "." "." "." "." "bp" "bn"]
   :h ["wr" "wp" "." "." "." "." "bp" "br"]
   })

(defn valid-x? [x] 
  (contains? #{:a :b :c :d :e :f :g :h} x))

(defn valid-y? [y]
  (<= 0 y 7))

(defn valid-pos? [x y]
  (and (valid-x? x) (valid-y? y)))

(defn not-valid-pos? [x y]
  (not (valid-pos? x y)))

(defn contains-char? [the-string, the-char]
  (not= (some #(= the-char %) the-string) nil))

(defn occupied? [chessboard x y]
  (not (contains-char? (get (get chessboard x) y) \.)))

(defn get-x-num [x-keyword] 
  (get {:a 0, :b 1, :c 2, :d 3, :e 4, :f 5, :g 6, :h 7} x-keyword))

(defn get-x-keyword [x-num]
  (get [:a :b :c :d :e :f :g :h] x-num))

(defn calc-offset-x [x offset]
  (get-x-keyword (+ (get-x-num x) offset)))

(defn calc-offset-y [y offset]
  (+ y offset))

(defn valid-x-offset? [x offset]
  (and
   (valid-x? x)
   (not= (calc-offset-x x offset) nil)))

(defn valid-y-offset? [y offset]
  (and 
    (valid-y? y)
    (valid-y? (calc-offset-y y offset))))

(defn valid-movement [chessboard fromx fromy tox toy]
  (and 
    (valid-pos? fromx fromy)
    (valid-pos? tox toy)
    (occupied? chessboard tox toy)))

(defn get-piece [chessboard x y]
  (if (and (valid-pos? x y) (occupied? chessboard x y))
      (get (get chessboard x) y)))
    
(defn piece-color [chessboard x y] 
  (if (and (valid-pos? x y) (occupied? chessboard x y))
    (if (= (get (get-piece chessboard x y) 0) \w)
      :white
      :black)))

(defn piece-name 
  ([the-string] (let [name (get the-string 1)]
                  (cond
                    (= name \p) :pawn
                    (= name \r) :rook
                    (= name \n) :knight
                    (= name \b) :bishop
                    (= name \q) :queen
                    (= name \k) :king
                    :else :empty)))
  
  ([chessboard x y] (if (and (valid-pos? x y) (occupied? chessboard x y))
                      (piece-name (get-piece chessboard x y))
                      :empty)))
