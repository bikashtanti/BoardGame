package com.example.boardgame

class BoardDesign {
var boardsize=arrayOf<Array<Int>>()
  fun BoardDesign(){
        for(i in 1..5)
            for(j in 1..8)
               boardsize[i-1][j-1]=0

    }

}