Start:
    MOV     BL,C0
    CALL    30
    HALT

    ORG     30
;
; This iterates over a linked list and adds the numbers it contains.
; Overflows are ignored. 
; CL will be used, but restored.
; 00 at address marks end of linked list. 
;
; param1    BL  (restored)      start of linked list; address in RAM
;
; return    AL                  sum of addition
;
; author    Kelvin Louis
;
AddLinkedList:
    MOV     AL,00       ; result    
    PUSH    BL          ; save in stack for restoration
    PUSH    CL          ; save in stack for restoration

Loop:
    MOV     CL,[BL]     ; get value from linked list
    ADD     AL,CL       ; add number of linked list
    
    INC     BL          
    MOV     BL,[BL]     ; get next address
        
    CMP     BL,00       ; check if linked list is at the end
    JNZ     Loop

Done:    
    POP     CL
    POP     BL
    RET
    
LinkedList:
    ORG     C0
    DB      01
    DB      C4
    
    ORG     C4
    DB      02
    DB      D2

    ORG     D2
    DB      03
    DB      E3

    ORG     E3
    DB      04
    DB      F2

    ORG     F2
    DB      05
    DB      00
    
    END