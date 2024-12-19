<?php
    include_once("conexao.php");
        $pratos = array (

            array (
                'codigo' => 'jardim-cogumelos',
                'nome' => 'Jardim de Cogumelos',
                'categoria' => 'Entradas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 12.00,
                'calorias' => 290,
                'destaque' => 0

            ),

            array (
                'codigo' => 'camarao-alho',
                'nome' => 'Camarões Ao Alho',
                'categoria' => 'Entradas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 16.00,
                'calorias' => 340,
                'destaque' => 1

            ),

            array (
                'codigo' => 'salada-grega',
                'nome' => 'Salada Grega',
                'categoria' => 'Entradas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 11.00,
                'calorias' => 180,
                'destaque' => 0

            ),

            array (
                'codigo' => 'brie-geleia',
                'nome' => 'Tapas de Queijo Brie e Geleia',
                'categoria' => 'Entradas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 14.00,
                'calorias' => 400,
                'destaque' => 0

            ),

            array (
                'codigo' => 'picanha-brasileira',
                'nome' => 'Picanha à Brasileira',
                'categoria' => 'Pratos Principais',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 28.00,
                'calorias' => 890,
                'destaque' => 1

            ),

             array (
                'codigo' => 'costelinha',
                'nome' => 'Costelinha de Porco',
                'categoria' => 'Pratos Principais',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 29.00,
                'calorias' => 930,
                'destaque' => 0

            ),

            array (
                'codigo' => 'salmao-legumes',
                'nome' => 'Salmão Aos Legumes',
                'categoria' => 'Pratos Principais',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 29.00,
                'calorias' => 690,
                'destaque' => 1

            ),

            array (
                'codigo' => 'churrasco-misto',
                'nome' => 'Churrasco Misto',
                'categoria' => 'Pratos Principais',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 26.00,
                'calorias' => 700,
                'destaque' => 0

            ),

            array (
                'codigo' => 'cheesecake-cereja',
                'nome' => 'Cheese Cake de Cereja',
                'categoria' => 'Sobremesas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 16.00,
                'calorias' => 680,
                'destaque' => 1

            ),

            array (
                'codigo' => 'flan-frutas-vermelhas',
                'nome' => 'Flan de Frutas Vermelhas',
                'categoria' => 'Sobremesas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 14.00,
                'calorias' => 620,
                'destaque' => 0

            ),

            array (
                'codigo' => 'petit-gateau',
                'nome' => 'Petit Gateau',
                'categoria' => 'Sobremesas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 19.00,
                'calorias' => 720,
                'destaque' => 0

            ),

            array (
                'codigo' => 'creme-papaya',
                'nome' => 'Creme de Papaya com Cassis',
                'categoria' => 'Sobremesas',
                'descr' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales justo eu mauris tincidunt, id dignissim magna elementum. Sed euismod efficitur tortor eu facilisis. Proin augue nunc, luctus hendrerit velit sit amet, iaculis porta velit. In vulputate tristique urna. Praesent tempus ipsum augue, sit amet tristique lacus semper cursus.',
                'valor' => 15.00,
                'calorias' => 520,
                'destaque' => 0

            )


        );

        foreach ($pratos as $dados) {
            $valores = [
                'codigo' => $dados['codigo'],
                'nome' => $dados['nome'],
                'categoria' => $dados['categoria'],
                'descr' => $dados['descr'],
                'valor' => $dados['valor'],
                'calorias' => $dados['calorias'],
                'destaque' => $dados['destaque'],
            ];

            $stringInsert = "INSERT INTO pratos (codigo, nome, categoria, descricao, valor, calorias, destaque) 
            values (:codigo, :nome, :categoria, :descr, :valor, :calorias, :destaque)";
            
            //$conn->prepare($stringInsert)->execute($valores);
            
        }

    ?>