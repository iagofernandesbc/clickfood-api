insert into cozinha (id_cozinha, nm_cozinha) values (1, 'Tailandesa');
insert into cozinha (id_cozinha, nm_cozinha) values (2, 'Indiana');

insert into restaurante (id_restaurante, nm_restaurante, vl_taxa_frete, id_cozinha) values (1, 'Thai Gourmet', 10, 1);
insert into restaurante (id_restaurante, nm_restaurante, vl_taxa_frete, id_cozinha) values (2, 'Thai Delivery', 9.50, 1);
insert into restaurante (id_restaurante, nm_restaurante, vl_taxa_frete, id_cozinha) values (3, 'Tuk Tuk Comida Indiana', 15, 2);

insert into estado (id_estado, nm_estado) values (1, 'Minas Gerais');
insert into estado (id_estado, nm_estado) values (2, 'São Paulo');
insert into estado (id_estado, nm_estado) values (3, 'Ceará');

insert into cidade (id_cidade, nm_cidade, id_estado) values (1, 'Uberlândia', 1);
insert into cidade (id_cidade, nm_cidade, id_estado) values (2, 'Belo Horizonte', 1);
insert into cidade (id_cidade, nm_cidade, id_estado) values (3, 'São Paulo', 2);
insert into cidade (id_cidade, nm_cidade, id_estado) values (4, 'Campinas', 2);
insert into cidade (id_cidade, nm_cidade, id_estado) values (5, 'Fortaleza', 3);

insert into forma_pagamento (id_forma_pagamento, nm_forma_pagamento) values (1, 'Cartão de crédito');
insert into forma_pagamento (id_forma_pagamento, nm_forma_pagamento) values (2, 'Cartão de débito');
insert into forma_pagamento (id_forma_pagamento, nm_forma_pagamento) values (3, 'Dinheiro');

insert into permissao (id_permissao, nm_permissao, ds_permissao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id_permissao, nm_permissao, ds_permissao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');