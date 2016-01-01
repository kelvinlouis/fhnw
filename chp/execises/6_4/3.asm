Start:
    MOV     BL,C0
    CALL    30
    HALT

    ORG     30
;
;
; param1    BL
;
; author    Kelvin Louis
;
Build:
    MOV     CL,00           ; used to temporarily store previous address
    PUSH    CL
Forward:
    PUSH    BL              ; push current address for backwards traversing
    
    INC     BL              ; addr+1
    MOV     BL,[BL]         ; next address
    
    CMP     BL,00           
    JZ      Backward        ; end reached, move backwards
    JMP     Forward         ; keep moving forward
Backward:
    POP     BL              ; get latest pushed address
    ADD     BL,02           ; addr+2
    POP     CL              ; get previous address
    
    CMP     CL,00           ; at the beginning
    JZ      Done

    MOV     [BL],CL         ; write previous address into addr+2
    
    PUSH    CL              ; traverse backwards and repeat
    JMP     Backward        

Done:
    RET

LinkedList:
    ORG     C0
    DB      01
    DB      C4
    DB      00
    
    ORG     C4
    DB      02
    DB      C8
    DB      00    

    ORG     C8
    DB      03
    DB      CC
    DB      00    

    ORG     CC
    DB      04
    DB      00
    DB      00

    END