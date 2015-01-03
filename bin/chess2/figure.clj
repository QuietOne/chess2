(ns chess2.figure
  (use chess2.chessboard))

(defn get-piece [chessboard x y]
  (if (and (valid-pos? x y) (occupied? chessboard x y))
      (get (get chessboard x) y)))

(defn piece-color [chessboard x y] 
  (if (and (valid-pos? x y) (occupied? chessboard x y))
    (if (= (get (get-piece chessboard x y) 0) \w)
      :white
      :black)))

(defn same-color? [chessboard x1 y1 x2 y2]
  (let [color1 (piece-color chessboard x1 y1)
        color2 (piece-color chessboard x2 y2)]
    (if (occupied? chessboard x1 y1)
      (= color1 color2)
      false)))

(defn white-color? [chessboard x y]
  (= :white (piece-color chessboard x y)))

(defn black-color? [chessboard x y]
  (= :black (piece-color chessboard x y)))

(defn not-same-color? [chessboard x1 y1 x2 y2]
  (not (same-color? chessboard x1 y1 x2 y2)))

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

(defn set-piece 
 ([chessboard x y the-string] (if (valid-pos? x y)
                                (assoc chessboard x (assoc (get chessboard x) y the-string))))
  
 ([chessboard x y name color] (cond
                                (and (= color :white) (= name :pawn)) (set-piece chessboard x y "wp")
                                (and (= color :white) (= name :rook)) (set-piece chessboard x y "wr")
                                (and (= color :white) (= name :knight)) (set-piece chessboard x y "wn")
                                (and (= color :white) (= name :bishop)) (set-piece chessboard x y "wb")
                                (and (= color :white) (= name :queen)) (set-piece chessboard x y "wq")
                                (and (= color :white) (= name :king)) (set-piece chessboard x y "wk")
                                (and (= color :black) (= name :pawn)) (set-piece chessboard x y "bp")
                                (and (= color :black) (= name :rook)) (set-piece chessboard x y "br")
                                (and (= color :black) (= name :knight)) (set-piece chessboard x y "bn")
                                (and (= color :black) (= name :bishop)) (set-piece chessboard x y "bb")
                                (and (= color :black) (= name :queen)) (set-piece chessboard x y "bq")
                                (and (= color :black) (= name :king)) (set-piece chessboard x y "bk")
                                :else chessboard)))

(defn remove-piece [chessboard x y]
  (set-piece chessboard x y "."))

(defn valid-movement? [fromx fromy tox toy]
  (and 
    (valid-pos? fromx fromy)
    (valid-pos? tox toy)))

(defn move-piece [chessboard moveable? fromx fromy tox toy]
  (if (moveable? chessboard fromx fromy tox toy)
    (let [piece (get-piece chessboard fromx fromy)]
      (set-piece (remove-piece chessboard fromx fromy) tox toy piece))
    chessboard))

(defn available-moves [chessboard moveable? x y]
  (reduce (fn [acc column]
            (reduce (fn [acc1 row]
                      (if (moveable? chessboard x y column row)
                        (conj acc1 [column row])
                        acc1)) acc (range 8))
            ) [] [:a :b :c :d :e :f :g :h]))