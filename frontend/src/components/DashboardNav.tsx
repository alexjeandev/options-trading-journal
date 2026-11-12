import {Link} from "react-router-dom";

function DashboardNav() {
    return (
        <header className="sticky top-0 z-50 bg-navbar">
            <nav className='relative flex items-center px-12 py-3'>
                <Link to="/dashboard"><img src="/calls-puts-commas.svg" alt="Calls Puts & Pancakes logo"
                                           className="h-8 w-auto"/> </Link>

                <div className="flex gap-9 text-nav-link text-sm font-normal
                leading-5 tracking-[-0.16px] absolute left-1/2 -translate-x-1/2">
                    <Link to="/dashboard" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Dashboard</Link>
                    <a href="/journal" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Journal </a>
                    <a href="/analytics" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Analytics</a>
                    <a href="news" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">News</a>
                    <a href="pancakes" className="inline-block hover:text-nav-hover hover:scale-105 transition-colors duration-300">Pancakes</a>

                </div>
            </nav>

            <div className="absolute bottom-0 left-0 h-px w-full
            bg-linear-to-r from-transparent via-border to-transparent" />
        </header>
    )
}
export default DashboardNav;