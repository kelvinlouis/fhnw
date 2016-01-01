Start:
    MOV     AL,80
    MOV     BL,05
    
    CALL    20              ; Add numbers of ranges
    HALT

    ORG     20
;
;   Adds a range of numbers, which start a specific point in the RAM.
;   AL and BL will be restored.
;
;   param1  AL  RAM address
;   param2  BL  length of range
;
;   return  CL  Sum of numbers
;   return  DL  Overflow flag
;
;   author Kelvin Louis
;
AddRange:
    MOV     CL,00           ; sum (result)
    MOV     DL,00           ; use temporarily and to return flag

    PUSH    AL              ; save AL for restoration
    PUSH    BL              ; save BL for restoration

    CMP     BL,00           ; Finish if no length was passed
    JZ      DoneAddRange
    
    ADD     AL,BL
LoopAddRange:
    DEC     AL
    DEC     BL
    MOV     DL,[AL]         ; use DL temporarily to store number from RAM
    ADD     CL,DL

    JO      Overflow        ; terminate on overflow
    
    CMP     BL,00 
    JNZ     LoopAddRange    ; continue adding

DoneAddRange:
    POP     BL              
    POP     AL
    RET

Overflow:
    MOV     DL,01
    JMP     DoneAddRange

Numbers:
    ORG     80
    DB      01
    DB      02
    DB      03
    DB      05
    DB      07
    DB      11
    DB      13
    DB      17

    END