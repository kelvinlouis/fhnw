; ------------------------------------------------
; Program looks for the highest (max) value of
; an array and returns the address of the first
; occurrence.
; ------------------------------------------------

    ORG     00
; ================================================
; Main
;
; Restriction:
; Only considering values from 00..7F
;
; Expected result at HALT:
; CL = 86 (address)
; DL = 7E (max value)
; ================================================
    MOV     AL,80               ; location of array
    MOV     BL,0A               ; length of array = 10
    CALL    20                  ; look for max
    HALT    

    ORG     20
; ================================================
; Searches address and max value of an array.
; AL and BL will be fully restored!
;
; Restriction:
; Only values between 00...7F are considered.
; It will return 00 as location and max value,
; if no valid arguments (inputs) are given.
;
; Input:
; AL = location of array
; BL = length of array
;
; Output:
; CL = address of max value (first occurrence)
; DL = max value
; ================================================
MaxArray:
    PUSH    AL                  ; save AL for restoration
    PUSH    BL                  ; save BL for restoration
    
    MOV     DL,00               ; DL = max value
    PUSH    DL                  ; temporarily store 00 as max address
    PUSH    DL                  ; temporarily store 00 as max value
    
    CMP     BL,00
    JZ      Done                ; length = 0; abort
    
    ADD     AL,BL               ; end address of array + 1
Loop:
    DEC     AL                  ; position - 1
    DEC     BL                  ; counter - 1   
    
    POP     CL                  ; get current max value
    MOV     DL,[AL]             ; get next value of array

    CMP     DL,00               ; look if value is > 00
    JS      ContinueLoop        ; next value is < 00; skip
    CMP     DL,80               ; look if value is > 80
    JNS     ContinueLoop        ; next value is > 80; skip
                      
    CMP     CL,DL
    JS      IsGreater           ; looks if new value > current
    JZ      IsGreater           ; or if new value = current (earlier occurrence)
ContinueLoop:        
    PUSH    CL                  ; add max value to stack
    CMP     BL,00
    JZ      Done                ; end of array reached
    JMP     Loop                ; keep iterating over array

IsGreater:
    POP     CL                  ; remove address
    PUSH    AL                  ; push new address
    MOV     CL,DL               ; make sure DL is stored in stack
    JMP     ContinueLoop

Done:
    POP     DL                  ; get max value
    POP     CL                  ; get address of max value
    POP     BL                  ; restore input
    POP     AL                  ; restore input
    RET

    ORG     80
; ------------------------------------------------
; Array
; ------------------------------------------------
    DB      02
    DB      19
    DB      00
    DB      4E
    DB      60
    DB      51
    DB      7E
    DB      80
    DB      13
    DB      7E

    END