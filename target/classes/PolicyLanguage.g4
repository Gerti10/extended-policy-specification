grammar PolicyLanguage;

//parser rules
policy_expression   :   positive_policy negative_policy* ;

//positive policy
positive_policy :   ship as_aggregates? from to where? group_by? ;

ship            :   SHIP (ASTERISK | ship_attribute (',' ship_attribute)*) ;
ship_attribute  :   PARAMETER ;

as_aggregates   :   AS_AGGREGATES aggr_func (',' aggr_func)* ;
aggr_func       :   PARAMETER ;

from    :   FROM table ;
table   :   PARAMETER ;

to         :   TO (ASTERISK | location (',' location)*);
location   :   PARAMETER ;

where       :   WHERE operand operator operand ((AND | OR) operand operator operand )*;
operator    :   OPERATOR;
operand     :   PARAMETER | TEXT | NUMBER;

group_by    :   GROUP_BY (ASTERISK | ship_attribute (',' ship_attribute)*);

//negative policy
negative_policy :   except except_as_aggregates? except_to except_where? except_group_by?;
except      :   EXCEPT (ASTERISK | except_attribute (',' except_attribute)*);
except_attribute    :   PARAMETER ;

except_as_aggregates    :   AS_AGGREGATES aggr_func (',' aggr_func)*;

except_to   :   TO (ASTERISK | location (',' location)* );

except_where    :   WHERE operand operator operand ((AND | OR) operand operator operand )*;

except_group_by : GROUP_BY ( except_attribute (',' except_attribute)* );


//lexer rules
SHIP        :   ('SHIP' | 'ship');
AS_AGGREGATES   :   ('AS AGGREGATES' | 'as aggregates');
FROM        :   ('FROM' | 'from');
TO          :   ('TO' | 'to');
WHERE       :   ('WHERE' | 'where' );
AND         :   ('AND' | 'and');
OR          :   ('OR' | 'or');
GROUP_BY    :   ('GROUP BY' | 'group by');
EXCEPT      :   ('EXCEPT' | 'except');
ASTERISK    :   '*';
PARAMETER   :   ('a'..'z' | 'A'..'Z' | '_')+ ('0'..'9')*;
TEXT        :   ('a'..'z' | 'A'..'Z' | '_' | '-' | '"')+('0'..'9')*;
NUMBER      :   ('0'..'9')+;
OPERATOR    :   ('<' | '≤' | '=' | '>' | '≥');
WHITESPACE  :   ' ' -> skip ;
NEWLINE     :   [\n] -> skip ;
TAB         :   [\t] -> skip;

