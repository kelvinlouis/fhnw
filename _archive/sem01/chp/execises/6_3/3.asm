;----------------------------------------
;   Exercise 6.3
;----------------------------------------

;   3
    
    ORG 68          ;   -
    MUL CL,AL       ;   A2 02 00 [Addr 68, 69, 6A]
    SHL DL          ;   CL 03 [Addr 6B, 6C]
    MOV [BL],DL     ;   D4 01 03 [Addr 6D, 6E, 6F]


    END             ; 00 [Addr 70]