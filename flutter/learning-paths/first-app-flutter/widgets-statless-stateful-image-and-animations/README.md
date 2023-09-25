# Flutter: Widgets, Stateless, Stateful, Images and Animations

The Usage of Widgets, Stateless, Stateful, Images and Animations


### Widgets

- Podemos associa-los à peças de lego; [💡Possuem tamanhos e cores diferentes]
- Componentes principais do Flutter;
- Possuem:
  - Classe
  - Paramêtros `Cor / Tamanho`
  - Métodos

### Parentes e Filhos

- Relacionamento entre os Widgets
- Conexão Direta ` Parent <-> Child `

### Container

- Não se pode sobrepor elementos com o ele, uma alternativa seria um `Stack`
- Não é possivel colocar um elemento **ao lado** do outro utilizando uma `Stack`

### Column 

- Para colocar um elemento **ao lado** do outro podemos usar um `Column`
- Em `Column` o primeiro elemento estará mais em cima e o próximo abaixo
- `mainAxisAlignment` é utilizado para a manipulação do eixo principal
- `crossAxisAligment` é utilizado para a manipulação no eixo secundário

### Row

- `Row` utilizamos quando precisamos alinhar elemento em linha
- Em `Row` o primeiro elemento estará mais à esquerda
- `mainExisAligment` vai mover o elemento em linha na horizontal
- `crossAxisAligment` nesse contexto irá mover o elemento em linha na vertical

### Overflow & Árvores de Widgets

- `Row` não tem limite horizontalmente, logo deve-se atentar para não passar pelo overflow 
`A IDE avisa mas é bão ficar esperto`
- `Flutter Inspector` nos ajuda a analisar a àrvore de widgets, ferramenta bem parecida com o blueprint quando se cria layouts com o `XML`;

## 💡 Dicas
- Para criar uma cor `RGB` podemos usar o `Color.fromARGB()`
- `Para plataforma Apple podemos utilizar o Cupertino e há o Material para plataformas Google. `