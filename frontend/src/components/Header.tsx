import {Link} from "react-router-dom";


function Header() {
    return (
        <header className="sticky top-0 z-50 bg-navbar">
            <nav className='relative flex items-center px-12 py-3'>
                <Link to="/"><img src="/calls-puts-commas.svg" alt="Calls Puts & Pancakes logo"
                                 className="h-8 w-auto"/> </Link>

                <div className="flex gap-9 text-nav-link text-sm font-normal
                leading-5 tracking-[-0.16px] absolute left-1/2 -translate-x-1/2">
                    <Link to="/" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Home</Link>
                    <a href="#preview" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Preview </a>
                    <a href="#features" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Feature </a>

                </div>

                <button className="right-12 absolute bg-violet text-gray-200 px-3 py-1 rounded-full
                hover:bg-purple-500 cursor-pointer hover:scale-110 transition-all duration-100 font-normal text-sm">
                    Sign in
                </button>
            </nav>

            <div className="absolute bottom-0 left-0 h-px w-full
            bg-linear-to-r from-transparent via-border to-transparent" />
        </header>
    )
}

export default Header