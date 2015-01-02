(ns chess2.army.classic
  (use chess2.chessboard))

;return vector of available moves
;en-passant is not implemented
(defn pawn-available-moves [chessboard x y]

  )

(defn rook-available-moves [chessboard x y])
(defn knight-available-moves [chessboard x y])
(defn bishop-available-moves [chessboard x y])
(defn queen-available-moves [chessboard x y])
(defn king-available-moves [chessboard x y])

;return if it is possible to move from to another space
(defn pawn-move? [chessboard fromx fromy tox toy]
  
  )
(defn rook-move? [chessboard fromx fromy tox toy])
(defn knight-move? [chessboard fromx fromy tox toy])
(defn bishop-move? [chessboard fromx fromy tox toy])
(defn queen-move? [chessboard fromx fromy tox toy])
(defn king-move? [chessboard fromx fromy tox toy])

;return new chessboard
(defn pawn-move [chessboard fromx fromy tox toy])
(defn rook-move [chessboard fromx fromy tox toy])
(defn knight-move [chessboard fromx fromy tox toy])
(defn bishop-move [chessboard fromx fromy tox toy])
(defn queen-move [chessboard fromx fromy tox toy])
(defn king-move [chessboard fromx fromy tox toy])