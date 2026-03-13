// API service - connects frontend to Spring Boot backend
const API_BASE = '/api/snippets';

const api = {
  getAll:       ()         => fetch(API_BASE).then(r => r.json()),
  getById:      (id)       => fetch(`${API_BASE}/${id}`).then(r => r.json()),
  create:       (data)     => fetch(API_BASE, { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(data) }).then(r => r.json()),
  update:       (id, data) => fetch(`${API_BASE}/${id}`, { method: 'PUT', headers: {'Content-Type':'application/json'}, body: JSON.stringify(data) }).then(r => r.json()),
  delete:       (id)       => fetch(`${API_BASE}/${id}`, { method: 'DELETE' }),
  search:       (kw)       => fetch(`${API_BASE}/search?kw=${kw}`).then(r => r.json()),
  filterByTag:  (tag)      => fetch(`${API_BASE}/filter/tag?tag=${tag}`).then(r => r.json()),
  filterByLang: (lang)     => fetch(`${API_BASE}/filter/lang?lang=${lang}`).then(r => r.json()),
  getPinned:    ()         => fetch(`${API_BASE}/pinned`).then(r => r.json()),
  bulkImport:   (list)     => fetch(`${API_BASE}/bulk`, { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(list) }).then(r => r.json()),
};
