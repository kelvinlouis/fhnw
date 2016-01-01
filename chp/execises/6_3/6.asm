Start:
    MOV     AL,77   ; [00] D0 00 77     ; STACK: BF (00)
    MOV     BL,33   ; [03] D0 01 33     ;
    PUSH    AL      ; [06] E0 00        ; STACK: BF 77 (TOS); BE (SP)
    CALL    10      ; [08] CA 10        ; STACK: BF 77, BE 0A (TOS), BD (SP)
    POP     AL      ; [0A] E1 00        ; STACK: BF 77 (SP), BE 0A, BD 33
    SUB     AL,BL   ; [0C] A1 00 01     ; AL = 44
    HALT            ; [0F] 00
    
    ORG     10
    PUSH    BL      ; [10] E0 01        ; STACK: BF 77, BE 0A, BD 33 (TOS); BC (SP)
    MOV     BL,[30] ; [12] D1 01 30     ; BL = 11
    ADD     AL,BL   ; [15] A0 00 01     ; AL = 88
    OUT     02      ; [18] F1 02        ;
    POP     BL      ; [1A] E1 01        ; STACK: BF 77, BE 0A (TOS); BD 33 (SP)
    RET             ; [1C] CB           ; STACK: BF 77 (TOS), BE 0A (SP), BD 33
    
    ORG     30
    DB      11      ; [30] 11
    
    END             ; [31] 00 