package com.example.wesle.sinopseonline


enum class MovieEnum : IMovieProperties{
    BATMAN_VS_SUPERMAN{
        override fun getSinopse() = "O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. " +
                "Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. " +
                "Bruce Wayne é um dos que acreditam nesta segunda hipótese. " +
                "Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa.\n"
        override fun getImage() = R.drawable.batmanxsuperman
    },
    TRANSFORMERS{
        override fun getSinopse() = "O destino da humanidade está em jogo quando duas raças de robôs, os Autobots e os vilões Decepticons, chegam à Terra." +
                " Os robôs possuem a capacidade de se transformarem em diferentes objetos mecânicos enquanto buscam a chave do poder supremo com a ajuda do jovem Sam.\n"
        override fun getImage() = R.drawable.transformers
    },
    IRON_MAN_3{
        override fun getSinopse() = "Depois de um inimigo reduzir o mundo de Tony Stark a destroços, o Homem de Ferro precisa aprender a confiar " +
                "em seus instintos para proteger aqueles que ama, especialmente sua namorada, e lutar contra seu maior medo: o fracasso.\n"
        override fun getImage() = R.drawable.ironman3
    },
    INVALID{
        override fun getSinopse() = "Error"
        override fun getImage() = 0
    }
}