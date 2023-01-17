
--rate data
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (1,1, 'Transferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido', 0, 3, 3);
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (2,2, 'Transferências até 10 dias da data de agendamento possuem uma taxa de $12 multiplicado pela quantidade de dias da data de agendamento até a data de transferência',10, 12, 9);
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (3,3, 'Acima de 10 até 20 dias da data de agendamento 8%', 20, 0, 8);
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (4,4, 'Acima de 20 até 30 dias da data de agendamento 6%', 30, 0, 6);
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (5,5, 'Acima de 30 até 40 dias da data de agendamento 4%', 40, 0, 4);
insert into rate (id, rate_Code, rate_Description, rate_Amount_Days, rate_Value_Dolar, rate_Value_Percent) values (6,6, 'Acima de 40 da data de agendamento 2%', 41, 0, 2);

-- account data
insert into account (id, account_limit, account_number, account_owner, account_type) values (1, 10000.00, 410301554, 'Marco Antonio Mendonça', 1)
insert into account (id, account_limit, account_number, account_owner, account_type) values (2, 20000.00, 420030156, 'Erika Ap. Pina', 2)
insert into account (id, account_limit, account_number, account_owner, account_type) values (3, 30000.00, 510201552, 'Nicolas Oliveira Pina', 1)
insert into account (id, account_limit, account_number, account_owner, account_type) values (4, 40000.00, 710401560, 'Julia Beatriz', 2)
