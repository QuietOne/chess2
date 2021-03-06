(ns chess2.army.classic.pawn
  (use chess2.figure)
  (use chess2.chessboard))

(defn eat? [chessboard fromx fromy tox toy]
  (and
    (and ;specific eating position
      (or ;left or right position
        (= (offset-x fromx tox) 1) 
        (= (offset-x fromx tox) -1))
      (if (white-color? chessboard fromx fromy) ;pawn go on different side deppending of color
        (= (offset-y fromy toy) -1)
        (= (offset-y fromy toy) 1)))
    (occupied? chessboard tox toy)
    (not-same-color? chessboard fromx fromy tox toy)))

;TODO: promote pawn

(defn move-forward? [chessboard fromx fromy tox toy]
  (and
    (= fromx tox)
    (not-occupied? chessboard tox toy)
    (if (white-color? chessboard fromx fromy)
      (= (offset-y fromy toy) -1)
      (= (offset-y fromy toy) 1))))

(defn move-two-steps? [chessboard fromx fromy tox toy]
  (and 
    (= fromx tox)
    (if (white-color? chessboard fromx fromy)
      (and ;white color
        (= fromy 1)
        (= (offset-y fromy toy) -2)
        (not-occupied? chessboard tox toy)
        (not-occupied? chessboard tox (dec toy))
      )
      (and ;black color
        (= fromy 6)
        (= (offset-y fromy toy) 2)
        (not-occupied? chessboard tox toy)
        (not-occupied? chessboard tox (inc toy))))))

;TODO: en-passant
(defn en-passant? [chessboard fromx fromy tox toy]
  false)

;return if it is possible to move from to another space
(defn moveable? [chessboard fromx fromy tox toy]
  (and 
    (valid-movement? fromx fromy tox toy)
    (or 
      (eat? chessboard fromx fromy tox toy)
      (move-forward? chessboard fromx fromy tox toy)
      (move-two-steps? chessboard fromx fromy tox toy)
      (en-passant? chessboard fromx fromy tox toy)
      )))