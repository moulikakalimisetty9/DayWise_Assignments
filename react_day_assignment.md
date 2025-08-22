**======================== BookExplorer.jsx =================================**



import { useState, useEffect } from "react";



export default function BookExplorer() {

&nbsp; const \[books, setBooks] = useState(\[]);

&nbsp; const \[loading, setLoading] = useState(false);

&nbsp; const \[search, setSearch] = useState("");

&nbsp; const \[language, setLanguage] = useState("all");

&nbsp; const \[sort, setSort] = useState("default");



&nbsp; useEffect(() => {

&nbsp;   fetchBooks();

&nbsp; }, \[search, language, sort]);



&nbsp; const fetchBooks = () => {

&nbsp;   setLoading(true);

&nbsp;   let url = "https://gutendex.com/books";



&nbsp;   // Add query params

&nbsp;   const params = \[];

&nbsp;   if (search) params.push(`search=${search}`);

&nbsp;   if (language !== "all") params.push(`languages=${language}`);

&nbsp;   if (params.length > 0) url += "?" + params.join("\&");



&nbsp;   fetch(url)

&nbsp;     .then((res) => res.json())

&nbsp;     .then((data) => {

&nbsp;       let bookList = data.results;



&nbsp;       // Sort by popularity (download\_count)

&nbsp;       if (sort === "popularity") {

&nbsp;         bookList = \[...bookList].sort(

&nbsp;           (a, b) => b.download\_count - a.download\_count

&nbsp;         );

&nbsp;       }



&nbsp;       setBooks(bookList);

&nbsp;       setLoading(false);

&nbsp;     })

&nbsp;     .catch(() => setLoading(false));

&nbsp; };



&nbsp; return (

&nbsp;   <div>

&nbsp;     <h2>📖 Public Domain Book Explorer</h2>



&nbsp;     {/\* Search bar \*/}

&nbsp;     <input

&nbsp;       type="text"

&nbsp;       placeholder="Search by title or author..."

&nbsp;       value={search}

&nbsp;       onChange={(e) => setSearch(e.target.value)}

&nbsp;     />



&nbsp;     {/\* Language filter \*/}

&nbsp;     <select onChange={(e) => setLanguage(e.target.value)}>

&nbsp;       <option value="all">All Languages</option>

&nbsp;       <option value="en">English</option>

&nbsp;       <option value="fr">French</option>

&nbsp;       <option value="de">German</option>

&nbsp;       <option value="es">Spanish</option>

&nbsp;     </select>



&nbsp;     {/\* Sort \*/}

&nbsp;     <select onChange={(e) => setSort(e.target.value)}>

&nbsp;       <option value="default">Default</option>

&nbsp;       <option value="popularity">Sort by Popularity</option>

&nbsp;     </select>



&nbsp;     {loading ? (

&nbsp;       <p>Loading books...</p>

&nbsp;     ) : (

&nbsp;       <div style={{ display: "flex", flexWrap: "wrap" }}>

&nbsp;         {books.map((b) => (

&nbsp;           <div

&nbsp;             key={b.id}

&nbsp;             style={{

&nbsp;               border: "1px solid gray",

&nbsp;               padding: 10,

&nbsp;               margin: 10,

&nbsp;               width: 250,

&nbsp;             }}

&nbsp;           >

&nbsp;             <h4>{b.title}</h4>

&nbsp;             <p>

&nbsp;               <strong>Author:</strong>{" "}

&nbsp;               {b.authors.map((a) => a.name).join(", ") || "Unknown"}

&nbsp;             </p>

&nbsp;             <p>Language: {b.languages.join(", ")}</p>

&nbsp;             <p>Downloads: {b.download\_count}</p>

&nbsp;           </div>

&nbsp;         ))}

&nbsp;       </div>

&nbsp;     )}

&nbsp;   </div>

&nbsp; );

}



=============== App.jsx =====================



import BookExplorer from "./components/BookExplorer";



function App() {

&nbsp; return (

&nbsp;   <div>

&nbsp;     <BookExplorer />

&nbsp;   </div>

&nbsp; );

}



export default App;



