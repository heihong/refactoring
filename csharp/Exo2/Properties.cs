using System.Collections.Generic;

namespace Soat.CleanCoders.Refactoring.Exo2
{
    public class Properties
    {
        private readonly Dictionary<string, string> _map = new Dictionary<string, string>();

        public string getProperty(string key)
        {
            return _map.ContainsKey(key)
                       ? _map[key]
                       : null;
        }

        public void setProperty(string key, string value)
        {
            if (_map.ContainsKey(key))
            {
                _map[key] = value;
            }
            else
            {
                _map.Add(key, value);
            }
        }
    }
}
