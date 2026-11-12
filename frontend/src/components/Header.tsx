function Header() {
    return (
        <header className="sticky top-0 z-50 bg-navbar">
            <nav className='relative flex items-center px-12 py-3'>
                <a href="/"><img src="/purplegradientfinal.png" alt="Calls Puts & Pancakes logo"
                                 className="h-15 w-auto"/></a>

                <div className="flex gap-9 text-nav-link text-sm font-normal
                leading-5 tracking-[-0.16px] absolute left-1/2 -translate-x-1/2">
                    <a href="" className="hover:text-nav-hover transition-colors duration-300">Home </a>
                    <a href="" className="hover:text-nav-hover transition-colors duration-300">Features </a>
                    <a href="" className="hover:text-nav-hover transition-colors duration-300">Preview </a>

                </div>

                <button className="right-12 absolute bg-violet text-gray-200 px-3 py-1 rounded-full
                hover:bg-purple-500 transition-colors duration-300 font-normal text-sm">
                    Sign in
                </button>
            </nav>

            <div className="absolute bottom-0 left-0 h-px w-full
            bg-linear-to-r from-transparent via-border to-transparent" />
        </header>
    )
}

export default Header