using System;

namespace Soat.CleanCoders.Refactoring.Exo2
{
    public class MissingTimePropertiesException : Exception
    {
        public override string Message { get; }

        public MissingTimePropertiesException(string message)
        {
            Message = message;
        }
    }
}
