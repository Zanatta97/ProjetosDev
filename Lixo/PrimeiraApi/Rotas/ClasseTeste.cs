using System.Runtime.CompilerServices;
using System.Security.Cryptography.X509Certificates;
using Microsoft.Extensions.Diagnostics.HealthChecks;

namespace PrimeiraApi.Rotas
{
    public static class ClasseTeste
    {
        public static List<Pessoa> Pessoas = new()
        {
            new (Guid.NewGuid(), "Teste1"),
            new (Guid.NewGuid(), "Teste2"),
            new (Guid.NewGuid(), "Teste3"),
            new (Guid.NewGuid(), "Teste4"),
            new (Guid.NewGuid(), "Teste5")

        };

        public static void MapClasseTeste(this WebApplication app)
        {
            app.MapGet("/pessoa", () => Pessoas);

            app.MapGet("/pessoa/{nome}",
                (string nome) => Pessoas.Find(x => x.Nome == nome));

            app.MapGet("/pessoa2{nome}", (string nome) => 
                {
                    return Pessoas.Find(x => x.Nome == nome);
                });

            app.MapPost("pessoa", (Pessoa pessoa) =>
            {
                Pessoas.Add(pessoa);
                return pessoa;
            });
        }
    }
}
